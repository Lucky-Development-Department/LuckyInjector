package dev.luckynetwork.ldd.sqlhelperinjection;

import com.github.alviannn.lib.dependencyhelper.DependencyHelper;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class SQLHelperInjection extends JavaPlugin {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Override
    public void onEnable() {
        DependencyHelper helper = new DependencyHelper(this.getClass().getClassLoader());
        File dir = new File(this.getDataFolder(), "libs");

        if (!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }
        if (!dir.exists()) {
            dir.mkdir();
        }

        try {
            helper.download("SQLHelper-2.4.jar", "https://github.com/Alviannn/SQLHelper/releases/download/2.4/SQLHelper-2.4.jar", dir.toPath());
            helper.loadDir(dir.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {

    }

}
