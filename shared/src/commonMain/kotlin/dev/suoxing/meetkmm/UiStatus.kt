package dev.suoxing.meetkmm

/**
 * Define several UI status.
 */
enum class UiStatus {

    /**
     * Indicates initial status, ui would do nothing with this status
     */
    INITIAL,

    /**
     * Indicates
     */
    LOADING,

    /**
     * Indicates that the refresh of the data causes the UI to display the refreshed state.
     */
    REFRESHING,

    /**
     * Indicates no data is found for this page.
     */
    EMPTY,

    /**
     * Indicates there is a serious problem with the data that will cause the page
     * to no longer be available.
     */
    ERROR,

    /**
     * Indicates data is fine so that UI can be relax and have a cup of tea.
     */
    IDLE
}