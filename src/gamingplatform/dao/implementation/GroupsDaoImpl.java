package gamingplatform.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import gamingplatform.dao.data.DaoDataMySQLImpl;
import gamingplatform.dao.exception.DaoException;
import gamingplatform.dao.interfaces.GroupsDao;
import gamingplatform.model.Group;

public class GroupsDaoImpl extends DaoDataMySQLImpl implements GroupsDao {
	
	private PreparedStatement selectGroupById, insertGroup, deleteGroupById, selectGroupsByUserId ;
	
	
	//costruttore
	public GroupsDaoImpl(DataSource datasource) {
		super(datasource);
	}
	
	@Override
	public void init() throws DaoException{
		try {
			super.init(); // connection initialization
			
			this.selectGroupById = connection.prepareStatement("SELECT * FROM groups WHERE ID=?");
			this.insertGroup = connection.prepareStatement("INSERT INTO article (title,text,authorID,issueID,page) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			this.selectGroupsByUserId = connection.prepareStatement("SELECT groups.id, groups.name, groups.description FROM user LEFT JOIN usergroups ON user.id = usergroups.id_user LEFT JOIN groups ON usergroups.id_groups=groups.id WHERE user.id=?");
			
			
		} catch (SQLException e) {
			throw new DaoException("Error initializing group dao", e);
		}
	}
	
	@Override
	public Group getGroup( int keyGroup) throws DaoException {
		
		try {
			this.selectGroupById.setInt(1, keyGroup);
		} catch (SQLException e) {
			
		}
		
		return null;
	}

	@Override
	public void insertGroup(Group group) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * estraggo i gruppi a cui appartiene l'utente con id keyUser
	 * @throws DaoException
	 */
	@Override
	public List<Group> getGroupsByUserId(int keyUser) throws DaoException {
		
		List<Group> lista=new ArrayList<Group>();
		
		try{
			
			this.selectGroupsByUserId.setInt( 1, keyUser);
			
			ResultSet rs = this.selectGroupsByUserId.executeQuery();
			
			group.setId(rs.getInt("id"));
			group.setName("name");
			group.setDescription("description");
			
		}catch (SQLException e) {
			throw new DaoException("Error get group User", e);
		}
		
		return lista;
	}

	@Override
	public void deleteGroupById() {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void destroy() {
	}
	
}