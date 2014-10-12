package com.company;

import java.io.*;
class Main
{
    public static void main(String[] args)
    {
        try {
            FileReader Input = new FileReader(args[0]);
            File fl = new File(args[0]);
            char buf[] = new char[(int) fl.length()];
            int count=0;
            String content = new String();
            Input.read(buf);
            Input.close();
            for ( int i=0; i<buf.length; i++ ){
                if(buf[i]=='{'){
                    content+=buf[i]+"\n    ";
                    i++;
                    count++;
                    do{
                        if (buf[i] == '}') {
                            content += "\n";
                            count--;
                            for (int j = 0; j < count; j++)
                                content += "    ";
                            content+=buf[i];
                            if(buf[i+1]!='}') {
                                content += "\n";
                                for (int j = 0; j < count; j++)
                                    content += "    ";
                            }
                        }
                        else {
                            content += buf[i];
                            if(buf[i]=='{'){
                            count++;
                            content+="\n";
                            for (int j = 0; j < count; j++)
                                content += "    ";
                            }
                            else {
                                if ((buf[i] == ';')&&(buf[i+1]!='}')) {
                                    content += "\n";
                                    for (int j = 0; j < count; j++)
                                        content += "    ";
                                }
                            }
                        }
                        i++;
                    } while(count!=0);
                }
                else{
                    content+=buf[i];
                }
            }
            FileWriter Output = new FileWriter(args[1]);
            Output.write(content);
            Output.close();
        }
        catch(Exception e)
        {
            System.out.println("Something is wrong....");
        }
    }
}
