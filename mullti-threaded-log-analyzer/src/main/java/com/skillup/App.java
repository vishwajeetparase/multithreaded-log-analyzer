public class Main {

    public static void main(String[] args) throws Exception {
    //   // Configuration (e.g., read configuration file, set up logging)
    //   String logFilePath = args[0]; // Assuming log file path is passed as an argument
    //   LogParser parser = new TextLogParser(); // Replace with your specific parser
  
    //   // Create reader, processor(s), and report generator instances (as needed)
    //   LogReader reader = new FileReader(logFilePath, parser);
    //   List<LogProcessor> processors = new ArrayList<>();
    //   processors.add(new StatisticsProcessor()); // Example processor
    //   ReportGenerator reportGenerator = new TextReportGenerator(); // Example report generator
  
    //   // Start threads for processing and potentially report generation
    //   ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    //   executorService.submit(() -> processLogs(reader, processors));
    //   if (reportGenerator != null) {
    //     executorService.submit(() -> generateReport(processors, reportGenerator));
    //   }
  
    //   // Handle thread termination and any final tasks (optional)
    //   executorService.shutdown();
    //   if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
    //     executorService.shutdownNow(); // Force shutdown if waiting times out
    //   }
  
    //   System.out.println("Log analysis completed!");
    // }
  
    // private static void processLogs(LogReader reader, List<LogProcessor> processors) {
    //   for (LogEntry logEntry : reader.readEntries()) {
    //     for (LogProcessor processor : processors) {
    //       processor.process(logEntry);
    //     }
    //   }
    // }
  
    // private static void generateReport(List<LogProcessor> processors, ReportGenerator reportGenerator) {
    //   // Collect data from processors for report generation
    //   List<LogEntry> processedEntries = new ArrayList<>(); // Or get data from processors
    //   reportGenerator.generateReport(processedEntries);
    
  
    String folderPath = "path/to/folder";

    // Create a thread pool
    int numThreads = Runtime.getRuntime().availableProcessors(); // Use available processors
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);
    //ExecutorService executor = Executors.newFixedThreadPool(10);

    // Get all files in the folder
    File folder = new File(folderPath);
    File[] files = folder.listFiles((dir, name) -> name.endsWith(".json") || name.endsWith(".txt") || name.endsWith(".xml"));

    if (files == null) {
      throw new FileNotFoundException("Folder not found or empty: " + folderPath);
    }else{
      for (File file : files) {
        executor.submit(() -> processFile(file));
    }
    }
    executor.shutdown();
  }

  private static void processFile(File file) {
    try {
      String content = Files.lines(file.toPath()).collect(Collectors.joining("\n"));
      List<LogEntry> logEntries = null;
      if (file.getName().endsWith(".json")) {
          logEntries = jsonParser.parse(content);
      }
      if (logEntries != null) {
        for (LogEntry entry : logEntries) {
            System.out.println("Processed Log Entry: " + entry);
            // Further processing of the log entry
        }
    }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
  