class Solution {
    public int countSubstrings(String s) {
        int odd = 0;
        int even = 0;
        int n = s.length();
        for(int axis = 0; axis<n; axis++){
            for(int orbit = 0; axis-orbit >= 0 && axis+orbit < n; orbit++){
                if(s.charAt(axis-orbit) != s.charAt(axis+orbit)){
                    break;
                }
                odd++;
            }
        }
          for(double axis = 0.5; axis<n; axis++){
            for(double orbit = 0.5; axis-orbit >= 0 && axis+orbit < n; orbit++){
                if(s.charAt((int)(axis-orbit)) != s.charAt((int)(axis+orbit))){
                    break;
                }
                even++;
            }
        }
        return odd+even;
    }
}