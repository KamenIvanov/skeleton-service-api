package com.pe.skeleton.api.rest;

/**
 * @author kamen on 1.06.22 г.
 */
public class RestUrl {

    public static final String APP_VERSION = "/v1";

    // Public ones
    public static final String ACCOUNTS       = APP_VERSION + "/accounts";

    // Publications
    public static final String PUBLICATIONS = APP_VERSION + "/publications";
    public static final String SEARCH       = PUBLICATIONS + "/search";

    // Secured ones
    // All endpoints under this path, requires the account to be logged in
    // All endpoints outside this path, are free of use by anonymous accounts
    public static final String SECURED = APP_VERSION + "/secured";

    // Accounts
    public static final String SETTINGS              = SECURED + "/settings";
    public static final String SESSIONS              = SECURED + "/sessions";
    public static final String SECURED_SUBSCRIPTIONS = SECURED + "/subscriptions";

    // Publications
    public static final String SECURED_PUBLICATIONS  = SECURED + "/publications";
    public static final String SECURED_METRICS       = SECURED + "/metrics";

    private RestUrl() {
        // Constants only
    }
}
