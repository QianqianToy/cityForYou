package command;

import service.MemberService;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class FindByNameCommand extends UserCommand {

    private String name;
    private String passkey;
    private String type;

    public void execute(MemberService memberService) {
        try {
            result = memberService.findBy(name,passkey,type);
        } catch (Exception e) {
            exception = e;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasskey() {
        return passkey;
    }

    public void setPasskey(String passkey) {
        this.passkey = passkey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}