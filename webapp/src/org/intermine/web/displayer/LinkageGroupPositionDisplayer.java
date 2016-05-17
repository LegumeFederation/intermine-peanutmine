package org.intermine.bio.web.displayer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.intermine.api.InterMineAPI;
import org.intermine.model.InterMineObject;
import org.intermine.util.DynamicUtil;
import org.intermine.web.displayer.ReportDisplayer;
import org.intermine.web.logic.config.ReportDisplayerConfig;
import org.intermine.web.logic.results.ReportObject;

/**
 * Displays the linkage group position (cM), and linked linkage group name.
 * Could get fancier with some sort of linkage group number line, for example.
 *
 * @author Sam Hokin
 */
public class LinkageGroupPositionDisplayer extends ReportDisplayer {

    /**
     * Construct with config and the InterMineAPI.
     * @param config to describe the report displayer
     * @param im the InterMine API
     */
    public LinkageGroupPositionDisplayer(ReportDisplayerConfig config, InterMineAPI im) {
        super(config, im);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void display(HttpServletRequest request, ReportObject reportObject) {

        // one assumes THIS is needed
        InterMineObject imObj = reportObject.getObject();

        // is this needed?
        String imoClassName = imObj.getClass().getSimpleName();
        request.setAttribute("objectClass", imoClassName);

        try {

            Double position = (Double) imObj.getFieldValue("position");
            InterMineObject linkageGroup = (InterMineObject) imObj.getFieldValue("linkageGroup");
            String linkageGroupName = (String) linkageGroup.getFieldValue("primaryIdentifier");

            request.setAttribute("position", position);
            request.setAttribute("linkageGroupName", linkageGroupName);
            
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

}
