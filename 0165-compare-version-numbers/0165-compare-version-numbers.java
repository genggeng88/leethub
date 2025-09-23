class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.equals("") && version2.equals("")) return 0;
        // if (version1.equals("") && !version2.equals("")) return -1;
        // if (!version1.equals("") && version2.equals("")) return 1;

        String[] vers1 = splitVersion(version1);
        String[] vers2 = splitVersion(version2);
        
        if (vers1[0].equals("") && !vers2[0].equals("")) return -1;
        if (vers2[0].equals("") && !vers1[0].equals("")) return 1;
        if (vers1[0].equals(vers2[0]) || Integer.parseInt(vers1[0]) == Integer.parseInt(vers2[0])) return compareVersion(vers1[1], vers2[1]);
        if (Integer.parseInt(vers1[0]) < Integer.parseInt(vers2[0])) return -1;
        if (Integer.parseInt(vers1[0]) > Integer.parseInt(vers2[0])) return 1;

        return 0;
    }

    private String[] splitVersion(String version) {
        int n=version.length(), i=0;
        while(i < n && version.charAt(i) == '0') i++;
        if (i == n) return new String[]{"", ""};
        if (version.charAt(i) == '.') return new String[]{"", version.substring(i+1)};
        int j=i;
        while (i < n && version.charAt(i) != '.') i++;
        if (i == n) return new String[]{version.substring(j, i), ""};
        return new String[]{version.substring(j, i), version.substring(i+1)};
    }
}