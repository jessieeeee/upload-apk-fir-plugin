package com.demo.plugin

public class UploadApp{
    private String code
    private String message
    private UploadResult data

    String getCode() {
        return code
    }

    void setCode(String code) {
        this.code = code
    }

    String getMessage() {
        return message
    }

    void setMessage(String message) {
        this.message = message
    }

    UploadResult getData() {
        return data
    }

    void setData(UploadResult data) {
        this.data = data
    }

    @Override
    public String toString() {
        return "UploadApp{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public class UploadResult{
        private String buildKey
        private Integer buildType
        private Integer buildIsFirst
        private Integer buildIsLastest
        private Integer buildFileSize
        private String buildName
        private String buildVersion
        private String buildVersionNo
        private Integer buildBuildVersion
        private String buildIdentifier
        private String buildIcon
        private String buildDescription
        private String buildUpdateDescription
        private String buildScreenShots
        private String buildShortcutUrl
        private String buildQRCodeURL
        private String buildCreated
        private String buildUpdated

        String getBuildKey() {
            return buildKey
        }

        void setBuildKey(String buildKey) {
            this.buildKey = buildKey
        }

        Integer getBuildType() {
            return buildType
        }

        void setBuildType(Integer buildType) {
            this.buildType = buildType
        }

        Integer getBuildIsFirst() {
            return buildIsFirst
        }

        void setBuildIsFirst(Integer buildIsFirst) {
            this.buildIsFirst = buildIsFirst
        }

        Integer getBuildIsLastest() {
            return buildIsLastest
        }

        void setBuildIsLastest(Integer buildIsLastest) {
            this.buildIsLastest = buildIsLastest
        }

        Integer getBuildFileSize() {
            return buildFileSize
        }

        void setBuildFileSize(Integer buildFileSize) {
            this.buildFileSize = buildFileSize
        }

        String getBuildName() {
            return buildName
        }

        void setBuildName(String buildName) {
            this.buildName = buildName
        }

        String getBuildVersion() {
            return buildVersion
        }

        void setBuildVersion(String buildVersion) {
            this.buildVersion = buildVersion
        }

        String getBuildVersionNo() {
            return buildVersionNo
        }

        void setBuildVersionNo(String buildVersionNo) {
            this.buildVersionNo = buildVersionNo
        }

        Integer getBuildBuildVersion() {
            return buildBuildVersion
        }

        void setBuildBuildVersion(Integer buildBuildVersion) {
            this.buildBuildVersion = buildBuildVersion
        }

        String getBuildIdentifier() {
            return buildIdentifier
        }

        void setBuildIdentifier(String buildIdentifier) {
            this.buildIdentifier = buildIdentifier
        }

        String getBuildIcon() {
            return buildIcon
        }

        void setBuildIcon(String buildIcon) {
            this.buildIcon = buildIcon
        }

        String getBuildDescription() {
            return buildDescription
        }

        void setBuildDescription(String buildDescription) {
            this.buildDescription = buildDescription
        }

        String getBuildUpdateDescription() {
            return buildUpdateDescription
        }

        void setBuildUpdateDescription(String buildUpdateDescription) {
            this.buildUpdateDescription = buildUpdateDescription
        }

        String getBuildScreenShots() {
            return buildScreenShots
        }

        void setBuildScreenShots(String buildScreenShots) {
            this.buildScreenShots = buildScreenShots
        }

        String getBuildShortcutUrl() {
            return buildShortcutUrl
        }

        void setBuildShortcutUrl(String buildShortcutUrl) {
            this.buildShortcutUrl = buildShortcutUrl
        }

        String getBuildQRCodeURL() {
            return buildQRCodeURL
        }

        void setBuildQRCodeURL(String buildQRCodeURL) {
            this.buildQRCodeURL = buildQRCodeURL
        }

        String getBuildCreated() {
            return buildCreated
        }

        void setBuildCreated(String buildCreated) {
            this.buildCreated = buildCreated
        }

        String getBuildUpdated() {
            return buildUpdated
        }

        void setBuildUpdated(String buildUpdated) {
            this.buildUpdated = buildUpdated
        }


        @Override
        public String toString() {
            return "UploadApp{" +
                    "buildKey='" + buildKey + '\'' +
                    ", buildType=" + buildType +
                    ", buildIsFirst=" + buildIsFirst +
                    ", buildIsLastest=" + buildIsLastest +
                    ", buildFileSize=" + buildFileSize +
                    ", buildName='" + buildName + '\'' +
                    ", buildVersion='" + buildVersion + '\'' +
                    ", buildVersionNo='" + buildVersionNo + '\'' +
                    ", buildBuildVersion=" + buildBuildVersion +
                    ", buildIdentifier='" + buildIdentifier + '\'' +
                    ", buildIcon='" + buildIcon + '\'' +
                    ", buildDescription='" + buildDescription + '\'' +
                    ", buildUpdateDescription='" + buildUpdateDescription + '\'' +
                    ", buildScreenShots='" + buildScreenShots + '\'' +
                    ", buildShortcutUrl='" + buildShortcutUrl + '\'' +
                    ", buildQRCodeURL='" + buildQRCodeURL + '\'' +
                    ", buildCreated='" + buildCreated + '\'' +
                    ", buildUpdated='" + buildUpdated + '\'' +
                    '}';
        }
    }


}