package bitcamp.java106.pms.service;

import java.util.List;
import java.util.Map;

import bitcamp.java106.pms.domain.Classroom;

public interface ClassroomService {
    int delete(int no);
    List<Classroom> list(int pageNo, int pageSize);
    Classroom get(int no);
    int add(Classroom classroom);
    int update(Classroom classroom);
}
