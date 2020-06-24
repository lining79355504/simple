package asm;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:  lining17
 * Date :  2020-06-12
 */
public class Attacher {
    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
        String shell = "ps -ef | grep \"jar asm.TransformTarget\" |grep -v grep | awk '{print $2}'";
        List<String> list = runShell(shell);

        VirtualMachine vm = VirtualMachine.attach(list.get(0)); // 目标 JVM pid
        vm.loadAgent("/Users/mort/simple/apiAttach-agent/target/apiAttach-agent-1.0-SNAPSHOT-jar-with-dependencies.jar");
    }

    public static List<String> runShell(String shStr) {
        List<String> strList = new ArrayList<String>();
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh","-c",shStr},null,null);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line;
            process.waitFor();
            while ((line = input.readLine()) != null){
                strList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strList;
    }
}
