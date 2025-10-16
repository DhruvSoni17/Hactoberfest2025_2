class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        // 🧭 Define boundaries
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int columnBegin = 0;
        int columnEnd = matrix[0].length - 1;

        // 🔁 Traverse while boundaries are valid
        while (rowBegin <= rowEnd && columnBegin <= columnEnd) {

            // 1️⃣ Traverse Right → across the top row
            for (int j = columnBegin; j <= columnEnd; j++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++; // move top boundary down

            // 2️⃣ Traverse Down ↓
            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][columnEnd]);
            }
            columnEnd--; // move right boundary left

            // 3️⃣ Traverse Left ← (only if row still valid)
            if (rowBegin <= rowEnd) {
                for (int j = columnEnd; j >= columnBegin; j--) {
                    result.add(matrix[rowEnd][j]);
                }
                rowEnd--; // move bottom boundary up
            }

            // 4️⃣ Traverse Up ↑ (only if column still valid)
            if (columnBegin <= columnEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][columnBegin]);
                }
                columnBegin++; // move left boundary right
            }
        }

        return result;
    }
}
