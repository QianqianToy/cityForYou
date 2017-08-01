package command;

import domain.Member;
import service.MemberService;

import java.io.Serializable;

public abstract class UserCommand implements Serializable {

    //发送给服务器端的属性

    //传回给客户端的属性
    protected Object result;
    protected Exception exception;

    //具体的执行操作
    public abstract void execute(MemberService memberService);

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
