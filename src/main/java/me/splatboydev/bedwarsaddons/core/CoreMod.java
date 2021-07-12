package me.splatboydev.bedwarsaddons.core;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.CodeSource;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;


import net.minecraftforge.fml.relauncher.CoreModManager;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.MCVersion("1.8.9")
public class CoreMod implements IFMLLoadingPlugin {
	
	public CoreMod() {
		MixinBootstrap.init();
		Mixins.addConfiguration("mixins.bedwarsaddons.json");
		MixinEnvironment.getCurrentEnvironment().setObfuscationContext("searge");
		MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);

        CodeSource codeSource = this.getClass().getProtectionDomain().getCodeSource();
        if (codeSource != null) {
            URL location = codeSource.getLocation();
            try {
                File file = new File(location.toURI());
                if (file.isFile()) {
                    CoreModManager.getReparseableCoremods().remove(file.getName());
                }
            } catch (URISyntaxException ignored) {}
        } else {
            LogManager.getLogger().warn("No CodeSource, if this is not a development environment we might run into problems!");
            LogManager.getLogger().warn(this.getClass().getProtectionDomain());
        }
	}
	
	@Override
	public String[] getASMTransformerClass() {
		return new String[]{};
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		
	}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}

}
