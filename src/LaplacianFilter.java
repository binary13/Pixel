public class LaplacianFilter implements Filter {
    public void filter(PixelImage pi) {
        Pixel[][] data = pi.getData();
        Pixel[][] result = pi.getData();

        for (int row = 1; row < pi.getHeight()-1; row++) {
            for (int col = 1; col < pi.getWidth()-1; col++) {
                result[row][col] = lapRes(data, row, col);
            }
        }
        pi.setData(result);
    }

    public Pixel lapRes(Pixel[][] data, int row, int col) {
        int red = data[row][col].getRed() * 8;
        int green = data[row][col].getGreen() * 8;
        int blue = data[row][col].getBlue() * 8;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    red -= data[row+i][col+j].getRed();
                    green -= data[row+i][col+j].getGreen();
                    blue -= data[row+i][col+j].getBlue();
                }
            }
        }
        if (red < 0) red = 0;
        if (red > 255) red = 255;
        if (blue < 0) blue = 0;
        if (blue > 255) blue = 255;
        if (green < 0) green = 0;
        if (green > 255) green = 255;

        return new Pixel(red, green, blue);
    }
}
