package pl.hansonq.models.commands;

import pl.hansonq.models.UserModel;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by lukasz on 2017-11-04.
 */



public class KickCommand implements Command {
    @Override
    public void parseCommand(UserModel sender, List<UserModel> userModelList, String... args) {
        String nickToKick = args[0];
        Optional<UserModel> userModel = userModelList.stream()
                .filter(s -> s.getNickname().equals(nickToKick))
                .findAny();

        if(userModel.isPresent()){
            try {
                userModel.get().getSession().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            sender.sendMessage("Taki user nie istnieje");
        }
    }

    @Override
    public int argsCount() {
        return 1;
    }

    @Override
    public String error() {
        return "Użycie komendy to: /kick tutaj_nick";
    }
}