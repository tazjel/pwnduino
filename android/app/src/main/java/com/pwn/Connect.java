package com.pwn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jcraft.jsch.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;


public class Connect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        JSch jsch=new JSch();
        String user="root@10.55.176.112";
        String host="127.0.0.1";
        Session session=jsch.getSession(host,user,22);
        UserInfo ui = new UserInfo() {
            @Override
            public String getPassphrase() {
                return null;
            }

            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public boolean promptPassword(String s) {
                return false;
            }

            @Override
            public boolean promptPassphrase(String s) {
                return false;
            }

            @Override
            public boolean promptYesNo(String s) {
                return false;
            }

            @Override
            public void showMessage(String s) {

            }
        };
        Channel channel=session.openChannel("exec");

        session.connect();


        session.setUserInfo(ui);
    }
}
