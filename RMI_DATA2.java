import java.rmi.Naming;
import java.util.Arrays;
import java.util.Locale;
import RMI.DataService;

public class RMI_DATA2 {
    public static void main(String[] args) throws Exception {
        DataService service = (DataService) Naming.lookup("rmi://36.50.135.242/RMIDataService");
        String studentCode = "B23DCCN067";
        String qCode = "rHeX1Kod";

        String s = (String) service.requestData(studentCode, qCode);
        String[] nums = s.split(",");
        double[] a = new double[nums.length];
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = Double.parseDouble(nums[i]);
            sum += a[i];
        }
        double avg = sum / a.length;
        double variance = 0;
        for (double x : a) {
            variance += (x - avg) * (x - avg);
        }
        double stddev = Math.sqrt(variance / a.length);
        Arrays.sort(a);
        double p95 = a[(int) Math.ceil(a.length * 0.95) - 1];
        String res = String.format(Locale.US, "average=%.2f;stddev=%.2f;p95=%.2f", avg, stddev, p95);

        service.submitData(studentCode, qCode, res);
    }
}
