package servlet;

import dao.ReviewDao;
import dao.ReviewDaoImpl;
import entity.Review;
import net.sf.json.JSONArray;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lenovo on 2018/7/12.
 */
public class GetReviewBySponsorIDServlet extends HttpServlet {
    public GetReviewBySponsorIDServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw=resp.getWriter();
//        String sponsorID=req.getParameter("sponsorID");
        String sponsorID="7ad528dd6c8f46bf8407de39487de1a3";
        try{
            ReviewDao reviewDao=new ReviewDaoImpl();
            List<Review> reviewList=reviewDao.getReviewBySponsorID(sponsorID);
            JSONArray array = JSONArray.fromObject(reviewList);
            String strArray = array.toString();
            pw.print(strArray);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}