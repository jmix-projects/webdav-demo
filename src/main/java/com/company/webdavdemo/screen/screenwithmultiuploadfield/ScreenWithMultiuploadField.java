package com.company.webdavdemo.screen.screenwithmultiuploadfield;

import io.jmix.core.FileRef;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.FileMultiUploadField;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import io.jmix.ui.upload.TemporaryStorage;
import io.jmix.webdav.service.WebdavDocumentsManagementService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.UUID;

@UiController("w_ScreenWithMultiuploadField")
@UiDescriptor("screen-with-multiupload-field.xml")
public class ScreenWithMultiuploadField extends Screen {
    @Autowired
    private WebdavDocumentsManagementService webdavDocumentsManagementService;
    @Autowired
    private FileMultiUploadField fileMultiUploadField;
    @Autowired
    private Notifications notifications;
    @Autowired
    private TemporaryStorage temporaryStorage;
    @Autowired
    private FileMultiUploadField fileMultiUploadFieldVersioned;

    @Subscribe
    public void onInit(InitEvent event) {
        fileMultiUploadField.addQueueUploadCompleteListener(e -> {
            for (Map.Entry<UUID, String> entry : fileMultiUploadField.getUploadsMap().entrySet()) {
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();

                // save file to FileStorage
                FileRef fileRef = temporaryStorage.putFileIntoStorage(fileId, fileName);

                // webdav: begin
                // create and save WebdavDocument
                webdavDocumentsManagementService.createNonVersioningDocumentByFileRef(fileRef);
                // webdav: end
            }
            notifications
                    .create()
                    .withType(Notifications.NotificationType.HUMANIZED)
                    .withCaption("Uploaded files: " + fileMultiUploadField.getUploadsMap().values())
                    .show();
            fileMultiUploadField.clearUploads();
        });

        fileMultiUploadField.addFileUploadErrorListener(e ->
                notifications
                        .create()
                        .withCaption("File upload error")
                        .withType(Notifications.NotificationType.HUMANIZED)
                        .show());

        // uploading WebdavDocuments with enabled versioning
        fileMultiUploadFieldVersioned.addQueueUploadCompleteListener(e -> {
            for (Map.Entry<UUID, String> entry : fileMultiUploadFieldVersioned.getUploadsMap().entrySet()) {
                UUID fileId = entry.getKey();
                String fileName = entry.getValue();

                // save file to FileStorage
                FileRef fileRef = temporaryStorage.putFileIntoStorage(fileId, fileName);

                // webdav: begin
                // create and save WebdavDocument
                webdavDocumentsManagementService.createVersioningDocumentByFileRef(fileRef);
                // webdav: end
            }
            notifications
                    .create()
                    .withType(Notifications.NotificationType.HUMANIZED)
                    .withCaption("Uploaded files: " + fileMultiUploadFieldVersioned.getUploadsMap().values())
                    .show();
            fileMultiUploadFieldVersioned.clearUploads();
        });

        fileMultiUploadFieldVersioned.addFileUploadErrorListener(e ->
                notifications
                        .create()
                        .withCaption("File upload error")
                        .withType(Notifications.NotificationType.HUMANIZED)
                        .show());
    }
}