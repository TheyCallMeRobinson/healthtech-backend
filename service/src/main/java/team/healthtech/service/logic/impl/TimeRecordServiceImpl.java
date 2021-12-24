package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.db.repository.DoctorRepository;
import org.springframework.validation.annotation.Validated;
import team.healthtech.db.repository.TimeRecordsRepository;
import team.healthtech.service.logic.TimeRecordService;
import team.healthtech.service.mapper.TimeRecordMapper;
import team.healthtech.service.model.TimeRecordDto;
import team.healthtech.service.security.Profile;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@Validated
public class TimeRecordServiceImpl implements TimeRecordService {

    private static final Logger logger = LoggerFactory.getLogger(TimeRecordServiceImpl.class);
    private final ObjectProvider<Profile> profileProvider;
    private final TimeRecordsRepository repository;
    private final TimeRecordMapper mapper;
    private final DoctorRepository doctorRepository;
    public TimeRecordServiceImpl(
        ObjectProvider<Profile> profileProvider,
        TimeRecordsRepository repository,
        TimeRecordMapper mapper,
        DoctorRepository doctorRepository
    ) {
        this.profileProvider = profileProvider;
        this.repository = repository;
        this.mapper = mapper;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public TimeRecordDto createTimeRecord(TimeRecordDto dto) throws Exception {
        logger.info("New timerecord create request");
        TimeRecordEntity targetEntity = mapper.toEntity(dto);

        DoctorEntity doctor = doctorRepository.findById(dto.getDoctorId()).orElseThrow();
        targetEntity.setDoctor(doctor);
        for (TimeRecordEntity tr :
            repository.getTimeRecordEntitiesByDoctorId(doctor.getId())) {
            if (tr.getDate().compareTo(targetEntity.getDate()) < 0)
                throw new Exception("this timetable already exists");
        }
        TimeRecordEntity result = repository.save(targetEntity);
        TimeRecordDto timeRecordDto = mapper.fromEntity(result);
        timeRecordDto.setDoctorId(doctor.getId());
        return timeRecordDto;
    }

    @Override
    public void updateTimeRecord(TimeRecordDto timeRecordDto, int timeRecordsId) {
        logger.info("Time record with id {} update request by {}", timeRecordsId, profileProvider.getIfAvailable());
        //timeRecordDto.setId(repository.findById(timeRecordsId).orElseThrow().getId());
        TimeRecordEntity entity = repository.findById(timeRecordsId).orElseThrow();
        mapper.merge(timeRecordDto, entity);
        entity.setId(timeRecordsId);
        entity.setDoctor(doctorRepository.findById(timeRecordDto.getDoctorId()).orElseThrow());

        repository.save(entity);
    }

    @Override
    public void deleteTimeRecord(int timeRecordId) {
        logger.info("Time record with id {} delete request by {}", timeRecordId, profileProvider.getIfAvailable());
        repository.deleteById(timeRecordId);
    }

    @Override
    public TimeRecordDto getTimeRecordByDoctorId(Date date, Integer doctorId) {
        if (date == null) {
            date = Date.valueOf(java.time.LocalDate.now());
        }
        TimeRecordEntity e = repository.getTimeRecordEntityByDateAndDoctorId(date, doctorId);
        TimeRecordDto timeRecordDto = mapper.fromEntity(e);
        timeRecordDto.setDoctorId(doctorId);
        return timeRecordDto;
    }

    @Override
    public List<TimeRecordDto> getScheduleByDatesAndDoctorId(List<Date> dates, Integer doctorId) {
        List<TimeRecordEntity> list = new ArrayList<>();
        for (Date d : dates) {
            TimeRecordEntity e = repository.getTimeRecordEntityByDateAndDoctorId(d, doctorId);
            list.add(e);
        }
        List<TimeRecordDto> resultList = mapper.fromEntities(list);
        for (TimeRecordDto dto :
            resultList) {
            dto.setDoctorId(doctorId);
        }
        return resultList;
    }

    @Override
    public String getFreeTimeByDoctor(int doctorId) {
        List<TimeRecordDto> list = mapper.fromEntities(repository.getFreeTimeRecordsOfDoctor(doctorId));
        Map<Date, List<String>> map = new TreeMap<>();
        for(var i : list) {
            map.putIfAbsent(i.getDate(), new ArrayList<>());
            map.get(i.getDate()).add(i.getStartTime().toString());
        }

        StringBuilder response = new StringBuilder("[");
        for (var i : map.keySet()) {
            response.append("{" + "\"date\":" + '"').append(i.toString()).append('"').append(",");
            response.append("\"freeTime\":[");
            for (var j : map.get(i)) {
                response.append('"').append(j).append('"').append(",");
            }
            response.append("]},");
        }
        response.append("]");
        String strResponce = response.toString();
        strResponce = strResponce.replaceAll("},}","}}");
        strResponce = strResponce.replaceAll("},]","}]");
        strResponce = strResponce.replaceAll("],}","]}");
        strResponce = strResponce.replaceAll("\",]","\"]");
        return strResponce;
    }

    @Override
    public String getBusyTimeByDoctor(int doctorId) {
        List<TimeRecordEntity> list = repository.getBusyTimeRecordsOfDoctor(doctorId);
        Map<Date, List<String>> map = new TreeMap<>();
        for(var i : list) {
            map.putIfAbsent(i.getDate(), new ArrayList<>());
            map.get(i.getDate()).add(i.getStartTime().toString());
        }

        StringBuilder response = new StringBuilder("[");
        for (var i : map.keySet()) {
            response.append("{" + "\"date\":" + '"').append(i.toString()).append('"').append(",");
            response.append("\"busyTime\":[");
            for (var j : map.get(i)) {
                response.append('"').append(j).append('"').append(",");
            }
            response.append("]},");
        }
        response.append("]");
        String strResponce = response.toString();
        strResponce = strResponce.replaceAll("},}","}}");
        strResponce = strResponce.replaceAll("},]","}]");
        strResponce = strResponce.replaceAll("],}","]}");
        strResponce = strResponce.replaceAll("\",]","\"]");
        return strResponce;
    }

    @Override
    public List<TimeRecordDto> getAllEndedTimeRecordsOfPatient(int patientId) {
        return mapper.fromEntities(repository.getEndedTimeRecordsByPatientId(patientId));
    }

    @Override
    public List<TimeRecordDto> getAllPlannedTimeRecordsOfPatient(int patientId) {
        return mapper.fromEntities(repository.getPlannedTimeRecordsByPatientId(patientId));
    }

    @Override
    public TimeRecordDto getTimeRecordByDoctorIdAndDateAndTime(int doctorId, Date date, String time) {
        return mapper.fromEntity(repository.getTimeRecordByDoctorIdAndDateAndTime(doctorId, date, Time.valueOf(time)));
    }
}
