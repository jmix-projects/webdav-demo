package com.company.webdavdemo.screen.wdwithenabledversioning;

import io.jmix.ui.screen.*;
import com.company.webdavdemo.entity.WDWithEnabledVersioning;

@UiController("w_WDWithEnabledVersioning.browse")
@UiDescriptor("wd-with-enabled-versioning-browse.xml")
@LookupComponent("wDWithEnabledVersioningsTable")
public class WDWithEnabledVersioningBrowse extends StandardLookup<WDWithEnabledVersioning> {
}