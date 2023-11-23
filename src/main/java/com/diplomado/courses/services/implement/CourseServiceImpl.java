package com.diplomado.courses.services.implement;

import com.diplomado.courses.domain.entities.Course;
import com.diplomado.courses.dto.CourseDTO;
import com.diplomado.courses.repositories.CourseRepository;
import com.diplomado.courses.services.CourseService;
import com.diplomado.courses.services.mapper.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseDTO> listCourses() {
//        List<Course> courses = courseRepository.findAll();
//        return courses.stream().map(courseMapper::toDto).collect(Collectors.toList());

        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO save(CourseDTO dto) {
/*      Course course = courseMapper.toEntity(dto);
        Course savedCourse = courseRepository.save(course);
        return courseMapper.toDto(savedCourse);*/
        return this.courseMapper
                .toDto(this.courseRepository
                        .save(this.courseMapper
                                .toEntity(dto)));
    }

    @Override
    public Optional<CourseDTO> getCourseById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer courseId) {
        courseRepository.deleteById(courseId);
    }
}
