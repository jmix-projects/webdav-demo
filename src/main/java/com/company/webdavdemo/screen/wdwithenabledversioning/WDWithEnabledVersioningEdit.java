package com.company.webdavdemo.screen.wdwithenabledversioning;

import io.jmix.ui.screen.*;
import com.company.webdavdemo.entity.WDWithEnabledVersioning;

@UiController("w_WDWithEnabledVersioning.edit")
@UiDescriptor("wd-with-enabled-versioning-edit.xml")
@EditedEntityContainer("wDWithEnabledVersioningDc")
public class WDWithEnabledVersioningEdit extends StandardEditor<WDWithEnabledVersioning> {
}