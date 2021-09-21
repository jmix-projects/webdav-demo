package com.company.webdavdemo.screen.wdwithdisabledversioning;

import io.jmix.ui.screen.*;
import com.company.webdavdemo.entity.WDWithDisabledVersioning;

@UiController("w_WDWithDisabledVersioning.browse")
@UiDescriptor("wd-with-disabled-versioning-browse.xml")
@LookupComponent("wDWithDisabledVersioningsTable")
public class WDWithDisabledVersioningBrowse extends StandardLookup<WDWithDisabledVersioning> {
}