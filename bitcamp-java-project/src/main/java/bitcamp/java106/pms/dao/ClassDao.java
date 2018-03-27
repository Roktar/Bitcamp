package bitcamp.java106.pms.dao;

import bitcamp.java106.pms.domain.Classroom;

public class ClassDao {
    Classroom[] classes = new Classroom[1000];
    int classIndex = 0;
    
    public void insert(Classroom classroom) {
        classroom.setNo(classIndex);
        this.classes[this.classIndex++] = classroom;
    }
    
    public Classroom[] list() {
        Classroom[] arr = new Classroom[classIndex];
        for (int i = 0; i < classIndex; i++) 
            arr[i] = classes[i];
        return arr;
    }
    
    public Classroom get(int i) {
        if (i < 0 || i >= classIndex)
            return null;
        return classes[i];
    }
    
    public void update(Classroom classroom) {
        classes[classroom.getNo()] = classroom;
    }
    
    public void delete(Classroom classroom) {
        classes[classroom.getNo()] = null;
    }
}