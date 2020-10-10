package com.demo.plugin

public class BundleApp {

    /**
     * id : 5592ceb6537069f2a8000000
     * type : ios
     * short : yk37
     * cert : {"icon":{"key":"xxxxx","token":"xxxxxx","upload_url":"http://upload.qiniu.com"},"binary":{"key":"xxxxx","token":"xxxxxx","upload_url":"http://upload.qiniu.com"}}
     */


    private CertBean cert

    public CertBean getCert() {
        return cert
    }

    public void setCert(CertBean cert) {
        this.cert = cert
    }

    public static class CertBean {
        /**
         * icon : {"key":"xxxxx","token":"xxxxxx","upload_url":"http://upload.qiniu.com"}
         * binary : {"key":"xxxxx","token":"xxxxxx","upload_url":"http://upload.qiniu.com"}
         */

        private IconBean icon
        private BinaryBean binary

        public IconBean getIcon() {
            return icon
        }

        public void setIcon(IconBean icon) {
            this.icon = icon
        }

        public BinaryBean getBinary() {
            return binary
        }

        public void setBinary(BinaryBean binary) {
            this.binary = binary
        }

        public static class IconBean {
            /**
             * key : xxxxx
             * token : xxxxxx
             * upload_url : http://upload.qiniu.com
             */

            private String key
            private String token
            private String upload_url

            public String getKey() {
                return key
            }

            public void setKey(String key) {
                this.key = key
            }

            public String getToken() {
                return token
            }

            public void setToken(String token) {
                this.token = token
            }

            public String getUpload_url() {
                return upload_url
            }

            public void setUpload_url(String upload_url) {
                this.upload_url = upload_url
            }
        }

        public static class BinaryBean {
            /**
             * key : xxxxx
             * token : xxxxxx
             * upload_url : http://upload.qiniu.com
             */

            private String key
            private String token
            private String upload_url

            public String getKey() {
                return key
            }

            public void setKey(String key) {
                this.key = key
            }

            public String getToken() {
                return token
            }

            public void setToken(String token) {
                this.token = token
            }

            public String getUpload_url() {
                return upload_url
            }

            public void setUpload_url(String upload_url) {
                this.upload_url = upload_url
            }
        }
    }
}
