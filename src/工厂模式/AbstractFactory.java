package 工厂模式;

public class AbstractFactory {
    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils = new MySqlDatabaseUtils();
        IConnection connection = iDatabaseUtils.getConnection();
        ICommand command = iDatabaseUtils.getCommand();
        connection.connect();
        command.command();
        connection.close();

    }
}


/*
    数据库组件
    变化部分：数据库种类、连接、命令
 */

interface IConnection{
    void connect();
    void close();
}

interface ICommand{
    void command();
}

interface IDatabaseUtils{
    IConnection getConnection();
    ICommand getCommand();
}

class MysqlConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("mysql connect");
    }

    @Override
    public void close() {
        System.out.println("mysql close");
    }
}

class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("mysql command");
    }
}

class MySqlDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}


class OracleConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("oracle connect");
    }

    @Override
    public void close() {
        System.out.println("oracle close");
    }
}

class OracleCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("oracle command");
    }
}

class OracleDatabaseUtils implements IDatabaseUtils{

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}

