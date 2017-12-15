package info.nightscout.utils;

import org.junit.Test;

import info.nightscout.androidaps.data.GlucoseStatus;
import info.nightscout.androidaps.data.Profile;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by kuchjir on 12/12/2017.
 */
public class BolusWizardTest {
    @Test
    public void doCalc() throws Exception {
        BolusWizard bw = new BolusWizard();
        // TempTarget tempTarget, Integer carbs, Double cob, Double bg, Double correction, Boolean includeBolusIOB, Boolean includeBasalIOB, Boolean superBolus, Boolean trend
        Profile profile = mock(Profile.class);
        when(profile.getIsf()).thenReturn(20d);
        when(profile.getTargetLow()).thenReturn(4d);
        when(profile.getTargetHigh()).thenReturn(8d);
        when(profile.getIc()).thenReturn(12d);

        GlucoseStatus glucoseStatus = mock(GlucoseStatus.class);
//        when(glucoseStatus.getGlucoseStatusData()).thenReturn(null);
        bw.glucoseStatus = glucoseStatus;

       //MainApp.instance().getConfigBuilder().getPumpDescription().bolusStep = 0.05;

        Double insulin38 = bw.doCalc(profile, null, 20, 0.0,3.8, 0d, 100d, true, true, false, false);
        System.out.println(insulin38);
        Double insulin48 = bw.doCalc(profile, null, 20, 0.0,4.2, 0d, 100d, true, true, false, false);
        System.out.println(insulin48);

    }

    @Test
    public void doCalc1() throws Exception {
    }

}