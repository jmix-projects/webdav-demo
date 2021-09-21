package com.company.webdavdemo.screen.wdwithdisabledversioning;

import io.jmix.ui.screen.*;
import com.company.webdavdemo.entity.WDWithDisabledVersioning;

@UiController("w_WDWithDisabledVersioning.edit")
@UiDescriptor("wd-with-disabled-versioning-edit.xml")
@EditedEntityContainer("wDWithDisabledVersioningDc")
public class WDWithDisabledVersioningEdit extends StandardEditor<WDWithDisabledVersioning> {
}