// Класс для демонстрации работы в многопоточном режиме
class SettingThread implements Runnable {
    private final int threadId;
    private final AppSettings appSettings;

    public SettingThread(int threadId, AppSettings appSettings) {
        this.threadId = threadId;
        this.appSettings = appSettings;
    }

    @Override
    public void run() {
        String key = "thread" + threadId;
        String value = "Value" + threadId;
        appSettings.setSetting(key, value);
        System.out.println("Thread " + threadId + ": Setting '" + key + "' set to '" + value + "'");
        System.out.println("Thread " + threadId + ": Retrieved value: " + appSettings.getSetting(key));
    }
}