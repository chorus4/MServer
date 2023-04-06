package com.example.velocityplugin;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.geysermc.cumulus.form.Form;

public class Forma implements Form {
    @Override
    public @NonNull String title() {
        return "Hello";
    }
}
