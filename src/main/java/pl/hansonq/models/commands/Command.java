package pl.hansonq.models.commands;

import pl.hansonq.models.UserModel;

import java.util.List;

/**
 * Created by lukasz on 2017-11-04.
 */
public interface Command {
    void parseCommand(UserModel model, List<UserModel> userList, String ... args);
    int argsCount();
    String error();
}