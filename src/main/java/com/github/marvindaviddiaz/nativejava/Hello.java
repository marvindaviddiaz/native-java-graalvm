package com.github.marvindaviddiaz.nativejava;

import java.io.IOException;

public class Hello {

    public static void main(String[] args) throws IOException, InterruptedException {
        new RestClient().test();
        new JdbcClient().test();
    }


}
