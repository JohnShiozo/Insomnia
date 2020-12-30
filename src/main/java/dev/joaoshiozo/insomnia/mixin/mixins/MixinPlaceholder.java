package dev.joaoshiozo.insomnia.mixin.mixins;

import client.insomnia.InsomniaMod;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(InsomniaMod.class)
public class MixinPlaceholder {
    // Here so project builds, if it won't be here when you import the project
    // the directory client/insomnia/mixin/mixins won't exist and it'll break the build process.
}
