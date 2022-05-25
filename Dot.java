public class Dot implements Constantes{
    
    int[] target;
    int[] currentPosition;
    int[] lastPosition;

    public Dot(){
        currentPosition = new int[2];
        currentPosition[X] = 0;
        currentPosition[Y] = 0;

        lastPosition = new int[2];
        lastPosition[X] = 0;
        lastPosition[Y] = 0;

        target = new int[2];
        target[X] = 5;
        target[Y] = 5;
    }


    public void move(int iden){
        lastPosition[X] = currentPosition[X];
        lastPosition[Y] = currentPosition[Y];
    
        if (iden == 1 && currentPosition[X] > 0){
            currentPosition[X] -= 1; 
        }
        if (iden == 2 && currentPosition[Y] < 19){
            currentPosition[Y] += 1; 
        }
        if (iden == 3 && currentPosition[X] < 19){
            currentPosition[X] += 1; 
        }
        if (iden == 4 && currentPosition[Y] > 0){
            currentPosition[Y] -= 1; 
        }
        /*if(target[X] != currentPosition[X]){
            currentPosition[X] += (target[X]-currentPosition[X])/Math.abs(target[X]-currentPosition[X]);
        }
        if(target[Y] != currentPosition[Y]){
            currentPosition[Y] += (target[Y]-currentPosition[Y])/Math.abs(target[Y]-currentPosition[Y]);
        } */
    }

}
