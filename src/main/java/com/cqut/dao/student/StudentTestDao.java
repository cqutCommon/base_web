package com.cqut.dao.student;

import java.util.List;

import com.cqut.entity.StudentTest;
import org.apache.ibatis.annotations.Param;


/**
 * @author qiaowei.wu
 * @version 1.0    2016/5/25 16:16
 */
public interface StudentTestDao {
    public int insertStudent(StudentTest studentTest);

    public List<StudentTest> getStudents(@Param("where") String where);
}
