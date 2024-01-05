import java.util.Scanner;
// Interface defining the water conservation system
interface WaterConservationSystem {
    int calculateTrappedWater(int[] blockHeights);
}

// Abstract class implementing the WaterConservationSystem interface
abstract class RainySeasonConservation implements WaterConservationSystem {
}

// Class extending RainySeasonConservation
class CityBlockConservation extends RainySeasonConservation {
    @Override
    public int calculateTrappedWater(int[] blockHeights) {
        if (blockHeights == null || blockHeights.length < 3) {
            return 0; // Not enough blocks to trap water
        }

        int n = blockHeights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Initialize leftMax array
        leftMax[0] = blockHeights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blockHeights[i]);
        }

        // Initialize rightMax array
        rightMax[n - 1] = blockHeights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blockHeights[i]);
        }

        int trappedWater = 0;

        // Calculate trapped water for each block
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - blockHeights[i];
        }

        return trappedWater;
    }
}

// Example usage
public class cityscape {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int i;
        WaterConservationSystem conservationSystem = new CityBlockConservation();
        System.out.println("Enter the number of blocks: ");
        int n = sc.nextInt();
        int[] bh = new int[n];
        System.out.println("Enter the heights of the blocks individually: ");
        for(i=0; i<n;i++)
        {
            bh[i] = sc.nextInt();
        }


        int trappedWater = conservationSystem.calculateTrappedWater(bh);
        System.out.println("Total trapped water: " + trappedWater + " units");
        sc.close();
    }
}
