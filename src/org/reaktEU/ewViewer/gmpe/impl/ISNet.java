package org.reaktEU.ewViewer.gmpe.impl;

/*
 * PGA GMPE used by PRESTo 0.2.8 for the ISNet network (Southern Italy):
 * Akkar and Bommer (BSSA,2007) for M >= 4, Emolo et al. (JGE,2010) for smaller magnitudes.
 */
// import useful packages
import org.reaktEU.ewViewer.utils.GeoCalc;
import org.reaktEU.ewViewer.gmpe.AttenuationPGV;
import org.reaktEU.ewViewer.gmpe.AttenuationPGA;
import org.quakeml.xmlns.bedRt.x12.EventParameters;
import org.reaktEU.ewViewer.data.*;

import static java.lang.Math.*;

public class ISNet implements AttenuationPGA, AttenuationPGV {
    // Returns median PGA, 16th-percentile PGA, 84th percentile PGA
    // Mag is the magnitude from the EW message

    @Override
    public Shaking getPGA(double magnitude, double sourceLat, double sourceLon,
                          double sourceDepthM, double targetLat, double targetLon,
                          double targetElevM, String amplificationType,
                          double amplificationProxyValueSI,
                          EventParameters eventParameters) {
        // Compute hypocentral distance
        double[] pEvent = GeoCalc.Geo2Cart(sourceLat, sourceLon, -sourceDepthM);
        double[] pTarget = GeoCalc.Geo2Cart(targetLat, targetLon, targetElevM);
        double distance = GeoCalc.Distance3D(pEvent, pTarget);

        double R = distance / 1000; // in kilometers

        // Compute log10(PGA_cm)
        double logpga, logpgasigma;
        if (magnitude >= 4) {
            // Akkar and Bommer (BSSA,2007)
            logpga = 1.647 + 0.767 * magnitude - 0.074 * pow(magnitude, 2) + (-3.162 + 0.321 * magnitude) * log10(sqrt(pow(R, 2) + pow(7.682, 2)));
            logpgasigma = sqrt(pow(0.557 - 0.049 * magnitude, 2) + pow(0.189 - 0.017 * magnitude, 2));
        } else {
            // Emolo et al. (JGE,2010)
            logpga = -2.024 + 0.469 * magnitude - 1.442 * log10(R) + 2;
            logpgasigma = 0.444;
        }

        // Return shaking in %g
        Shaking PGA = new Shaking();
        PGA.expectedSI = pow(10, logpga) / 981 * 100;
        PGA.percentile84 = pow(10, logpga + logpgasigma) / 981 * 100;
        PGA.percentile16 = pow(10, logpga - logpgasigma) / 981 * 100;

        return PGA;
    }

    @Override
    public Shaking getPGV(double magnitude, double sourceLat, double sourceLon,
                          double sourceDepthM, double targetLat, double targetLon,
                          double targetElevM, String amplificationType,
                          double amplificationProxyValueSI,
                          EventParameters eventParameters) {
        // Compute hypocentral distance
        double[] pEvent = GeoCalc.Geo2Cart(sourceLat, sourceLon, -sourceDepthM);
        double[] pTarget = GeoCalc.Geo2Cart(targetLat, targetLon, targetElevM);
        double distance = GeoCalc.Distance3D(pEvent, pTarget);

        double R = distance / 1000; // in kilometers

        // Compute log10(PGV_cm)
        double logpgv, logpgvsigma;
        if (magnitude >= 4) {
            // Akkar and Bommer (BSSA,2007)
            logpgv = -1.36 + 1.063 * magnitude - 0.079 * pow(magnitude, 2) + (-2.948 + 0.306 * magnitude) * log10(sqrt(pow(R, 2) + pow(5.547, 2)));
            logpgvsigma = sqrt(pow(0.85 - 0.096 * magnitude, 2) + pow(0.313 - 0.040 * magnitude, 2));
        } else {
            // Emolo et al. (JGE,2010)
            logpgv = -3.943 + 0.540 * magnitude - 1.458 * log10(R) + 2;
            logpgvsigma = 0.359;
        }

        // Return shaking in cm/s
        Shaking PGV = new Shaking();
        PGV.expectedSI = pow(10, logpgv);
        PGV.percentile84 = pow(10, logpgv + logpgvsigma);
        PGV.percentile16 = pow(10, logpgv - logpgvsigma);

        return PGV;
    }
}
