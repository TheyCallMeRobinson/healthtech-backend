package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import team.healthtech.db.entity.CommentEntity;
import team.healthtech.db.repository.CommentRepository;
import team.healthtech.service.logic.CommentService;
import team.healthtech.service.mapper.CommentMapper;
import team.healthtech.service.model.create_dto.CommentCreateDto;
import team.healthtech.service.model.CommentDto;
import team.healthtech.service.security.Profile;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@Service
@Validated
public class CommentServiceImpl implements CommentService {

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);
    private final ObjectProvider<Profile> profileProvider;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(
        ObjectProvider<Profile> profileProvider,
        CommentRepository commentRepository,
        CommentMapper commentMapper
    ) {
        this.profileProvider = profileProvider;
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public CommentDto createComment(@Valid CommentCreateDto commentCreateDto, Integer doctorId) {
        logger.info("New comment create request by {}", profileProvider.getIfAvailable());
        CommentEntity commentEntity = commentMapper.toEntity(commentCreateDto, doctorId);
        Date datetime = new Date(System.currentTimeMillis());
        commentEntity.setDate(datetime);
        return
            commentMapper.fromEntity(
                commentRepository.save(commentEntity));
    }

    @Override
    public List<CommentDto> getAllCommentsByDoctorId(Integer doctorId) {
        logger.info("Comments list get for doctor with id {} request by {}", doctorId, profileProvider.getIfAvailable());
        return commentMapper.fromEntities(commentRepository.getAllByDoctorId(doctorId));
    }

    @Override
    public List<CommentDto> getAllCommentsByDateAndPatientId(Integer patientId, Date date) {
        return commentMapper.fromEntities(commentRepository.getAllByPatientIdAndDate(patientId, date));
    }

}
