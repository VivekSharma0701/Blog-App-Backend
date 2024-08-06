package org.blog.backend.service;

import org.blog.backend.model.Announcement;
import org.blog.backend.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    // Get all announcements
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    // Get announcement by ID

    public Optional<Announcement> getAnnouncementById(Long id) {
        return announcementRepository.findById(id);
    }

    // Create a new announcement
    public Announcement createAnnouncement(Announcement announcement) {
        announcement.setCreatedDate(LocalDateTime.now());
        return announcementRepository.save(announcement);
    }

    // Update an existing announcement
    public Announcement updateAnnouncement(Long id, Announcement announcementDetails) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found with id " + id));

        announcement.setTitle(announcementDetails.getTitle());
        announcement.setContent(announcementDetails.getContent());
        announcement.setCreatedDate(announcementDetails.getCreatedDate());

        return announcementRepository.save(announcement);
    }

    // Delete an announcement
    public void deleteAnnouncement(Long id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Announcement not found with id " + id));

        announcementRepository.delete(announcement);
    }
}
