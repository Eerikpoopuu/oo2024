package ee.tlu.kontrolltoo.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AutodResult {
    public int total_count;
    public ArrayList<AutoInfo> results;
}
