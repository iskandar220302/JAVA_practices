public class IllegalTriangleException extends Exception{
    public IllegalTriangleException(String message){
        super(message);
    }

}
//Наследуется от класса Exception
//Используется для обработки исключительных ситуаций, связанных с нарушением условий треугольника
//используется для проверки правильности сторон треугольника