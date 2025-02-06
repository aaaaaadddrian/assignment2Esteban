import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class KSortGraphing extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KSortGraphing().setVisible(true);
            }
        });

    }

    public KSortGraphing(){
        super("XY Line Chart Example with JFreechart");
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    private JPanel createChartPanel(){
        String chartTitle = "Sorting Algorithms Sort-Times for K-Sorted Arrays";
        String xAxisLabel = "Items in Array";
        String yAxisLabel = "Time in Seconds";

        XYDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, xAxisLabel, yAxisLabel, dataset);

        customizeChart(chart);

        File imageFile = new File("KSORT-VERSION.png");
        int width = 1920;
        int height = 1080;

        try {
            ChartUtils.saveChartAsPNG(imageFile, chart, width, height);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        return new ChartPanel(chart);

    }

    private XYDataset createDataset() {

        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Insertion Sort");
        XYSeries series2 = new XYSeries("Bubble Sort");
        XYSeries series3 = new XYSeries("Selection Sort");
        XYSeries series4 = new XYSeries("Shell Sort");
        XYSeries series5 = new XYSeries("Quick Sort");
        XYSeries series6 = new XYSeries("Merge Sort");

        int[] size = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};


//        double[] insertS = {1.1207000352442265E-4, 2.3236999986693264E-4, 8.051350130699575E-4, 0.0028446000011172145, 0.016855505004059523, 0.06515735501307063, 0.25810590499313546, 3.5814913050096946, 14.734222754999063};
//
//        for (int i = 0; i < 9; i++) {
//            series1.add(size[i], insertS[i]);
//        }
//
//        double[] bubbleS = {1.1539499391801655E-4, 3.258699900470674E-4, 3.760799998417497E-4, 8.897049992810935E-4, 0.005076835001818836, 0.019654394988901914, 0.06526565999956802, 0.8001786600158084, 3.0478092350182124};
//
//        for (int i = 0; i < 9; i++) {
//            series2.add(size[i], bubbleS[i]);
//        }
//
//
//        double[] selectS = {1.0062998626381159E-4, 2.6870499714277686E-4, 2.7076501864939926E-4, 8.398749923799187E-4, 0.004974689992377534, 0.01956998500972986, 0.07736854000831954, 1.0809839800000192, 4.303432180010714};
//
//        for (int i = 0; i < 9; i++) {
//            series3.add(size[i], selectS[i]);
//        }

        double[] shellS = {3.923503099940717E-5, 6.358500104397535E-5, 8.311500423587858E-5, 1.0354501428082586E-4, 2.2464499343186617E-4, 4.6738997916691006E-4, 9.848850022535771E-4, 0.0035891050123609603, 0.00743195999530144};

        for (int i = 0; i < 9; i++) {
            series4.add(size[i], shellS[i]);
        }

        double[] quickS = {4.61999443359673E-6, 1.2340006651356817E-5, 1.0284996824339032E-5, 1.3275002129375934E-5, 1.1985015589743853E-5, 1.3719999697059392E-5, 2.769001293927431E-5, 9.040000732056797E-5, 1.675100007560104E-4};

        for (int i = 0; i < 9; i++) {
            series5.add(size[i], quickS[i]);
        }

        double[] mergeS = {5.141000146977603E-5, 4.6015006955713036E-5, 8.783501107245684E-5, 6.6390999709256E-4, 6.806049845181405E-4, 4.6742999693378807E-4,  0.0010038250009529292, 0.004194384993752465, 0.007718550000572577};

        for (int i = 0; i < 9; i++) {
            series6.add(size[i], mergeS[i]);
        }

//        dataset.addSeries(series1);
//        dataset.addSeries(series2);
//        dataset.addSeries(series3);
        dataset.addSeries(series4);
        dataset.addSeries(series5);
        dataset.addSeries(series6);

        return dataset;

    }

    private void customizeChart(JFreeChart chart){

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();


        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesPaint(3, Color.YELLOW);
        renderer.setSeriesPaint(4, Color.PINK);
        renderer.setSeriesPaint(5, Color.MAGENTA);

        renderer.setSeriesStroke(0, new BasicStroke(4.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));
        renderer.setSeriesStroke(3, new BasicStroke(4.0f));
        renderer.setSeriesStroke(4, new BasicStroke(3.0f));
        renderer.setSeriesStroke(5, new BasicStroke(2.0f));

        plot.setOutlinePaint(Color.BLUE);
        plot.setOutlineStroke(new BasicStroke(2.0f));

        plot.setRenderer(renderer);

        plot.setBackgroundPaint(Color.DARK_GRAY);


        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

    }

}
