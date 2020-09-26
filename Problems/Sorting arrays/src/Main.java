class ArraySorting {
    /**
     * @param array unordered sequence of strings
     * @return ordered array of strings
     */
    static String[] sortArray(String[] array) {
        String[] modifiedArray = array.clone();

        java.util.Arrays.sort(modifiedArray);

        return modifiedArray;
    }
}