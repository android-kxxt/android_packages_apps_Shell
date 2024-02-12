package com.termux.shared.shell.command.environment;

import android.content.Context;

import androidx.annotation.NonNull;

import com.termux.shared.shell.command.ExecutionCommand;

import java.io.File;
import java.util.HashMap;

public class PFAShellEnvironment extends UnixShellEnvironment{
    @NonNull
    @Override
    public HashMap<String, String> getEnvironment(@NonNull Context currentPackageContext, boolean isFailSafe) {
        HashMap<String, String> environment = new HashMap<>();
        environment.put(ENV_COLORTERM, "truecolor");
        environment.put(ENV_TERM, "xterm-256color");
        return environment;
    }

    @NonNull
    @Override
    public String getDefaultWorkingDirectoryPath() {
        return "/data/home/shell";
    }

    @NonNull
    @Override
    public String getDefaultBinPath() {
        return "/data/usr/bin";
    }

    @NonNull
    @Override
    public HashMap<String, String> setupShellCommandEnvironment(@NonNull Context currentPackageContext, @NonNull ExecutionCommand executionCommand) {
        return getEnvironment(currentPackageContext, executionCommand.isFailsafe);
    }
}
