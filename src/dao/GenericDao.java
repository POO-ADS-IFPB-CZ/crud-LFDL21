package dao;

import java.io.File;
import java.io.IOException;

public class GenericDao <T> {

    private File file;

    public GenericDao(String arquivo) throws IOException {
        file = new File(arquivo);
        if(!file.exists()){
            file.createNewFile();
        }
    }

}
