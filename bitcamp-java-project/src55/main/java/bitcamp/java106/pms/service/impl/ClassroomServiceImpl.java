package bitcamp.java106.pms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import bitcamp.java106.pms.dao.ClassroomDao;
import bitcamp.java106.pms.domain.Classroom;
import bitcamp.java106.pms.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    
    ClassroomDao classroomDao;
    
    public ClassroomServiceImpl(ClassroomDao classroomDao) {
        this.classroomDao = classroomDao;
    }

    @Override
    public int delete(int no) {
        return classroomDao.delete(no);
    }

    @Override
    public Classroom get(int no) {
        return classroomDao.selectOne(no);
    }

    @Override
    public int add(Classroom classroom) {
        return classroomDao.insert(classroom);
    }

    @Override
    public int update(Classroom classroom) {
        return classroomDao.update(classroom);
    }
    
    @Override
    public List<Classroom> list(int pageNo, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("startRowNo", (pageNo -1) * pageSize);
        params.put("pageSize", pageSize);
        
        return classroomDao.selectList(params);
    }
}
