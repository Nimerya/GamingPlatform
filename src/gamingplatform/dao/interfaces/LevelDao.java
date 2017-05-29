package gamingplatform.dao.interfaces;

import gamingplatform.dao.data.DaoData;
import gamingplatform.dao.exception.DaoException;
import gamingplatform.model.Group;
import gamingplatform.model.Level;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GregBug on 03/05/2017.
 */
public interface LevelDao extends DaoData {

    public Level getLevel();

    public Level getLevelById(int keyLevel) throws DaoException;

    public void insertLevel(Level level) throws DaoException;

    public void deleteLevel(int idLevel) throws DaoException;

    public void updateLevel(Level level) throws DaoException;

    public Level getNextLevel(Level currentLevel) throws DaoException;

    public List<Level> getLevels () throws DaoException;

    public List<Level> getLevelsOrdered () throws DaoException;


}

