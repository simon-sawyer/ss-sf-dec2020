package com.ss.sf.lms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.sf.lms.domain.LibraryBranch;

public class BranchDAO extends BaseDAO {

	public void addBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException{
		save("Insert into tbl_library_branch Values (?, ?, ?)", 
				new Object[] {branch.getBranchId(), branch.getBranchName(), branch.getBranchAddress()});
	}
	
	public void updateBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException{
		save("Update tbl_library_branch Set branchName = ?, branchAddress = ? Where branchId = ?", 
				new Object[] {branch.getBranchName(), branch.getBranchAddress(), branch.getBranchId()});
	}
	
	public void deleteBranch(LibraryBranch branch) throws ClassNotFoundException, SQLException{
		save("Delete From tbl_library_branch Where branchId = ?",
				new Object[] {branch.getBranchId()});
	}
	public LibraryBranch getBranch(int branchId) throws ClassNotFoundException, SQLException{
		pstmt = getConnection().prepareStatement("Select * From tbl_library_branch Where branchId = ?");
		pstmt.setInt(1,  branchId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			return new LibraryBranch(rs.getInt("branchId"), rs.getString("branchName"), rs.getString("branchAddress"));
		}else{
			return null;
		}
	}
	
	public List<LibraryBranch> readBranches() throws ClassNotFoundException, SQLException{
		List<LibraryBranch> branchList = new ArrayList<LibraryBranch>();
		pstmt = getConnection().prepareStatement("Select * From tbl_library_branch");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			branchList.add(new LibraryBranch(rs.getInt("branchId"), rs.getString("branchName"), rs.getString("branchAddress")));
		}
		return branchList;
	}
	
}
