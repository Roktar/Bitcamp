package step25.ex11;

import java.io.Serializable;
import java.sql.Date;
// DAO와 서비스 객체 사이에서 데이터를 실어나르는 용도로 사용
// 외부 저장소로 객체를 내보낼 수 있도록 serializable 추가
public class Board implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    int no;
    String title, content;
    Date registeredDate;
    
    public int getNo() {
        return no;
    }
    public Board setNo(int no) {
        this.no = no;
        return this;
    }
    public String getTitle() {
        return title;
    }
    public Board setTitle(String title) {
        this.title = title;
        return this;

    }
    public String getContent() {
        return content;
    }
    public Board setContent(String content) {
        this.content = content;
        return this;

    }
    public Date getRegisteredDate() {
        return registeredDate;
    }
    public Board setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
        return this;

    }
    
    @Override
    public String toString() {
        return "Board [no=" + no + ", title=" + title + ", content=" + content + ", registeredDate=" + registeredDate
                + "]";
    }
}
