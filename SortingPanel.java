import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortingPanel extends JPanel {
    private final int[] array;
    private final int arraySize = 100;
    private final int barWidth = 8;

    public SortingPanel() {
        array = new int[arraySize];
        generateArray();
        setLayout(new BorderLayout());
        JPanel controlPanel = new JPanel();
        JButton bubbleSortButton = new JButton("Bubble Sort");
        JButton selectionSortButton = new JButton("Selection Sort");
        JButton generateButton = new JButton("Generate Array");

        bubbleSortButton.addActionListener(e -> sortArray("Bubble Sort"));
        selectionSortButton.addActionListener(e -> sortArray("Selection Sort"));
        generateButton.addActionListener(e -> {
            generateArray();
            repaint();
        });

        controlPanel.add(bubbleSortButton);
        controlPanel.add(selectionSortButton);
        controlPanel.add(generateButton);
        add(controlPanel, BorderLayout.SOUTH);
    
    }

    private void generateArray() {
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(400) + 50; // Random heights
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < array.length; i++) {
            g.setColor(Color.BLUE);
            g.fillRect(i * barWidth, getHeight() - array[i], barWidth - 2, array[i]);
        }
    }

    public void sortArray(String algorithm) {
        new Thread(() -> {
            switch (algorithm) {
                case "Bubble Sort" -> SortingAlgorithms.bubbleSort(array, this);
                case "Selection Sort" -> SortingAlgorithms.selectionSort(array, this);
                // Add other sorting algorithms here
            }
        }).start();
    }

    public void refresh() {
        try {
            Thread.sleep(20); // Animation speed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

}
